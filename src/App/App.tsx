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
    <header className={classes.header}>
      <img src={logo} className={classes.logo} alt="logo" />
      <p>
        Edit <code className={classes.code}>src/App.tsx</code> and save to
        reload.
      </p>

      {loading ? <p>Loading</p> : null }
      {!loading && photos.length === 0 ? <p>No photos found</p> : null}
      {error && <div role="alert">Oh no!</div>}

      <label htmlFor="search">Search</label>
      <input id="search" type="text" value={query} onChange={e => setQuery(e.target.value)}></input>
     
     {photos.map(photo => 
      <img
        key={photo.id}
        width={photo.sizes[0].width}
        alt={photo.title}
        height={photo.sizes[0].height} 
        src={photo.sizes[0].url}/>

        
     )}
     
     
    </header>
  );
}
