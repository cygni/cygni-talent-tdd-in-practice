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
    <div>
      {error && <div role="alert">Oh no!</div>}
      <div>
        {loading
          ? 'Loading'
          : photos.length < 1
          ? 'No images found'
          : photos.map(el => (
              <img
                key={el.id}
                alt={el.title}
                src={el.sizes[0].url}
                width={el.sizes[0].width}
                height={el.sizes[0].height}
              />
            ))}
      </div>
      <label htmlFor="search">Search</label>
      <input
        type="search"
        id="search"
        value={query}
        onChange={e => setQuery(e.target.value)}
      />
    </div>
  );
}
