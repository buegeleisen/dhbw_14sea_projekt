import React, { Component } from 'react';
import TemperatureChart from './TemperatureChart.jsx';
import {Panel} from 'react-bootstrap';

const title = (
<h3>Temperature Chart</h3>
);


const machines = (

  <div className="col-md-12 container">
    <div >
      <h1 className="section-heading">Machine Overview</h1>
    </div>
    <div className="col-md-6">
      <Panel header={title}>
        <TemperatureChart />
      </Panel>
    </div>
    <div className="col-md-6">
      <Panel header="Drilling Speed">
        <TemperatureChart />
      </Panel>
    </div>
    <div className="col-md-6">
      <Panel header="Milling Speed">
        <TemperatureChart />
      </Panel>
    </div>
    <div className="col-md-6">
      <Panel header="Other Stuff">
        <TemperatureChart />
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
