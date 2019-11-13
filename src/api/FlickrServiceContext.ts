import { createContext, useContext } from 'react';
import FlickrService from './FlickrService';
import FlickrServiceMock from './FlickrServiceMock';

const FlickrServiceContext = createContext<FlickrService>(
  new FlickrServiceMock(),
);

export function useFlickrService() {
  return useContext(FlickrServiceContext);
}

export default FlickrServiceContext;
