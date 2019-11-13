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

  const textLoading = 'Loading';
  const textNoPhotos = 'No photos found';
  const initialSearchText = 'Cygni';

  return (
    <div>
        <div>{loading ? textLoading : textNoPhotos}</div>

        <label htmlFor="search-input">Search</label>
        <input
            id="search-input"
            defaultValue={initialSearchText}
            onChange={(e) => {
                setQuery(e.target.value);
            }}
        />

        <div role='alert'>{error ? error.message : ''}</div>

        <div>
            <ul>
                {photos.map((i) => {
                    return(
                    <div key={i.id}>
                        <div>Title: {i.title}</div>
                        <img alt={i.title} src={i.sizes[0].url} height={i.sizes[0].height} width={i.sizes[0].width}  />
                    </div>)})
                }
            </ul>
        </div>
    </div>
  );
}
