import React, { Component } from 'react';
import LineChart from './LineChart.jsx';
import {Panel} from 'react-bootstrap';




const machines = (

  <div className="col-md-12 container">
    <div >
      <h1 className="section-heading">Machine Overview</h1>
    </div>
    <div className="col-md-6">
      <Panel header="Milling Temperature">
        <div><LineChart labelName="Milling Temperature" /></div>
      </Panel>
    </div>
    <div className="col-md-6">
      <Panel header="Milling Speed">
        <LineChart labelName="Milling Speed"/>
      </Panel>
    </div>
    <div className="col-md-6">
      <Panel header="Drilling Temperature">
        <LineChart labelName="Drilling Temperature" />
      </Panel>
    </div>
    <div className="col-md-6">
      <Panel header="Drilling Speed">
        <LineChart labelName="Drilling Speed"/>
      </Panel>
    </div>
  </div>
);


export default React.createClass({


  render() {
      return (
          machines
            );
        }
  });
