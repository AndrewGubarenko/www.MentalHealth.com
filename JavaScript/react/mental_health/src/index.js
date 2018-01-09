import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import App from './App';
//import Head from './blocks/Head';
import registerServiceWorker from './registerServiceWorker';

//ReactDOM.render(<Head title="Mental Heaalth" />, document.getElementById('head'));
ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
