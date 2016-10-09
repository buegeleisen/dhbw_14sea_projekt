import React, { Component } from 'react';
import {Button} from 'react-bootstrap';

const index = (
  <div className="background intro">
    <div className="container">
      <img  src="logo_red_white.png"/>
      <h3>We make Data great again</h3>
      <Button bsSize="large">Login</Button>
    </div>
  </div>
);

export default React.createClass({


  render() {
      return (
          index
            );
        }
  });
