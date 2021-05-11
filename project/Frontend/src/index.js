import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { transitions, positions, Provider as AlertProvider } from 'react-alert'
import AlertTemplate from 'react-alert-template-oldschool-dark'


const alertOptions = {
  offset: '25px',
  timeout: 3000,
  transition: transitions.SCALE
}

ReactDOM.render(
  <AlertProvider 
      template={AlertTemplate}
      position={positions.TOP_CENTER}
      {...alertOptions}
      >
    <App />
    </AlertProvider>,
  document.getElementById('root')
);
