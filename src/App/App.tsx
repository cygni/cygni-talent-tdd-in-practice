import React, { useCallback, useState } from 'react';

import { useFlickrService } from '../api/FlickrServiceContext';
import { useRequest, useDebouncedValue } from '../utils';

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
      <div>
        <label htmlFor="searchbox">Search</label>
        <input
          id="searchbox"
          type="search"
          value={query}
          onChange={e => setQuery(e.target.value)}
        />
      </div>
      {loading ? (
        <span>Loading</span>
      ) : error !== undefined ? (
        <span role="alert">{error.message}</span>
      ) : photos.length === 0 ? (
        <span>No photos found</span>
      ) : (
        photos.map(({ id, title, sizes: [{ url, width, height }] }) => (
          <img key={id} alt={title} src={url} width={width} height={height} />
        ))
      )}
    </>
  );
}
