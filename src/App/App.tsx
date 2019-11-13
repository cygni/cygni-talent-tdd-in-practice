import React, { useCallback, useState } from 'react';

import { useFlickrService } from '../api/FlickrServiceContext';
import { useRequest, useDebouncedValue } from '../utils';

import classes from './App.module.css';
import logo from './logo.svg';

export default function App() {
  const flickrService = useFlickrService();

  const [query, setQuery] = useState('Cygni');
  const debouncedQuery = useDebouncedValue(250, query);

  const [photos = [], { loading, error }] = useRequest(
    useCallback(signal => flickrService.searchPhotos(debouncedQuery, signal), [
      debouncedQuery,
      flickrService,
    ]),
  );

  return (
    <>
      <header className="header">Flickr magic!</header>
      <p>{loading ? 'Loading' : photos.length > 0 ? '' : 'No photos found'}</p>
      <div>
        <label htmlFor="search-input">Search</label>
        <input
          id="search-input"
          defaultValue={'Cygni'}
          onChange={e => setQuery(e.target.value)}
        />
        <ul>
          {photos.map(photo => {
            return (
              <li key={photo.id}>
                <p>Title: {photo.title}</p>
                <img
                  alt={photo.title}
                  src={photo.sizes[0].url}
                  width={photo.sizes[0].width}
                  height={photo.sizes[0].height}
                />
              </li>
            );
          })}
        </ul>
      </div>
      {error !== undefined ? <p role="alert">{error.message}</p> : null}
    </>
  );
}
