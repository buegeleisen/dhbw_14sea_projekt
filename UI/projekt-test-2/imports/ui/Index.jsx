import React, { Component } from 'react';
import {Button, Panel, Glyphicon} from 'react-bootstrap';
import JaCom from './JaCom.jsx';

const index = (
  <div>
  <div className="background intro">
    <div className="container">
      <img  src="logo_red_white.png"/>
      <h3>We make Data great again</h3>
      <Button bsSize="large">Login</Button>
    </div>
  </div>
  <div className="section">
    <div className="container">
      <div className="inline"><h1>Principles of </h1><h1 className="ja">JA</h1><h1 className="com">.COM</h1></div>
      <div className="col-md-4 item">
        <Glyphicon className="sticker" glyph="signal" />
        <h4>NICE CHARTS</h4>
        <p>We used ChartJS 2 to display the data</p>
      </div>
      <div className="col-md-4 item">
        <Glyphicon className="sticker" glyph="time" />
        <h4>REAL TIME DATA CHANGES</h4>
        <p>With Meteor it is possible to show you data changes in real time</p>
      </div>
      <div className="col-md-4 item">
        <Glyphicon className="sticker" glyph="phone" />
        <h4>RESPONSIVE</h4>
        <p>We worked hard to make an responsive UI for your mobile device</p>
      </div>
    </div>
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
