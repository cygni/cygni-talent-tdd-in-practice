import React, { Component, StrictMode } from 'react';
import App from './App';
import FlickrServiceImpl from './api/FlickrServiceImpl';
import FlickrServiceContext from './api/FlickrServiceContext';

export default class Root extends Component {
  componentDidMount() {
    if (module.hot !== undefined) {
      module.hot.accept('./App', () => {
        this.forceUpdate();
      });
    }
  }

  componentWillUnmount() {
    if (module.hot !== undefined) {
      module.hot.decline('./App');
    }
  }

  render() {
    const flickrService = new FlickrServiceImpl(
      process.env.REACT_APP_FLICKR_API_KEY,
    );

    return (
      <StrictMode>
        <FlickrServiceContext.Provider value={flickrService}>
          <App />
        </FlickrServiceContext.Provider>
      </StrictMode>
    );
  }
}
