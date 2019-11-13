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

    const images = photos.map((photo) => {
        return <img
            key={photo.id}
            src={photo.sizes[0].url}
            alt={photo.title}
            height={photo.sizes[0].height}
            width={photo.sizes[0].width}/>
    });

  return (
    <div>
        {error && <div role={"alert"}>{error.message}</div>}
        {loading && <div>Loading</div>}
        {!loading && photos.length === 0 && <div>No photos found</div>}
        <label htmlFor="search">Search</label>
        <input type="text" id="search" defaultValue={"Cygni"} onChange={(event) => {setQuery(event.target.value)}}/>
        {images}
    </div>
  );
}
