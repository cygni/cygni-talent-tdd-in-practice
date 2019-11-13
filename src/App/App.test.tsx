import React from 'react';
import {
  wait,
  waitForElementToBeRemoved,
  fireEvent,
  render,
} from '@testing-library/react';
import App from './App';

import FlickrServiceMock from '../api/FlickrServiceMock';
import { Photo } from '../api/FlickrService';
import { createDeferred } from '../utils';

it('shows a loading message while loading', async () => {
  const photosDeferred = createDeferred<readonly Photo[]>();
  jest
    .spyOn(FlickrServiceMock.prototype, 'searchPhotos')
    .mockReturnValue(photosDeferred.promise);

  const { findByText, queryByText } = render(<App />);

  await findByText('Loading');

  expect(queryByText('No photos found')).toBeNull();

  photosDeferred.resolve([]);

  await waitForElementToBeRemoved(() => queryByText('Loading'));

  await findByText('No photos found');
});

it('shows an error message if something went wrong', async () => {
  const errorMessage = 'Oh no!';

  jest
    .spyOn(FlickrServiceMock.prototype, 'searchPhotos')
    .mockRejectedValue(new Error(errorMessage));

  const { findByRole } = render(<App />);

  const alertBox = await findByRole('alert');

  expect(alertBox).toHaveTextContent(errorMessage);
});

it('shows a search box and calls the service when entering some text', async () => {
  const searchPhotosSpy = jest.spyOn(
    FlickrServiceMock.prototype,
    'searchPhotos',
  );

  const { getByLabelText } = render(<App />);

  const initialSearchText = 'Cygni';
  const newSearchText = 'Talangprogrammet';

  const searchInput = getByLabelText('Search');

  expect(searchInput).toBeInTheDocument();
  expect(searchInput).toHaveValue(initialSearchText);

  await wait(() => {
    expect(searchPhotosSpy).toHaveBeenLastCalledWith(
      initialSearchText,
      expect.any(AbortSignal),
    );
  });

  fireEvent.change(searchInput, {
    target: { value: newSearchText },
  });

  await wait(() => {
    expect(searchPhotosSpy).toHaveBeenLastCalledWith(
      newSearchText,
      expect.any(AbortSignal),
    );
  });
});

it('fetches and displays images', async () => {
  const mockPhoto: Photo = {
    id: '123',
    title: 'Hej hej!',
    sizes: [{ url: 'http://placekitten.com/320/240', width: 320, height: 240 }],
  };

  jest
    .spyOn(FlickrServiceMock.prototype, 'searchPhotos')
    .mockResolvedValue([mockPhoto]);

  const { findByAltText } = render(<App />);

  const imageElement = await findByAltText(mockPhoto.title);

  const { url, width, height } = mockPhoto.sizes[0];

  expect(imageElement).toHaveAttribute('src', url);
  expect(imageElement).toHaveAttribute('width', width.toString());
  expect(imageElement).toHaveAttribute('height', height.toString());
});
