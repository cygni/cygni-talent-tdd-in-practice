import React, { useCallback, useState } from 'react';

import { useFlickrService } from '../api/FlickrServiceContext';
import { useRequest, useDebouncedValue } from '../utils';

import classes from './App.module.css';
import logo from './logo.svg';
import { Photo } from '../api/FlickrService';

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

  const onInput = (event: React.FormEvent<HTMLInputElement>) => {
    setQuery(event.currentTarget.value);
  };

  /* function Photo(photo: Photo) {
   *   return <img />;
   * } */

  const Photo = (photo: Photo) => (
    <img
      key={photo.id}
      id={photo.id}
      alt={photo.title}
      src={photo.sizes[0].url}
      width={photo.sizes[0].width}
      height={photo.sizes[0].height}
    />
  );

  return (
    <div>
      {loading ? <p>Loading</p> : <p> No photos found </p>}
      {error ? <p role="alert">Oh no!</p> : null}
      <label htmlFor="Search">Search</label>
      <input id="Search" value={query} onChange={onInput}></input>
      <div>{photos.map(Photo)}</div>
    </div>
  );
}
