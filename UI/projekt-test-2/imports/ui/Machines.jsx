import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';

import LineChart from './LineChart.jsx';
import {Panel} from 'react-bootstrap';
import { MillingTemperatureData, DrillingTemperatureData, MillingSpeedData, DrillingSpeedData } from '../api/chartData.js';



class Machines extends Component{
  render(){
    const machines = (

      <div className="col-md-12 container">
        <div >
          <h1 className="section-heading">Machine Overview</h1>
        </div>
        <div className="col-md-6">
          <Panel header="Milling Temperature">
            <div><LineChart labelName="Milling Temperature" yAxis={this.props.millingtemperaturedata} /></div>
          </Panel>
        </div>
        <div className="col-md-6">
          <Panel header="Milling Speed">
            <LineChart labelName="Milling Speed" yAxis={this.props.millingspeeddata}/>
          </Panel>
        </div>
        <div className="col-md-6">
          <Panel header="Drilling Temperature">
            <LineChart labelName="Drilling Temperature" yAxis={this.props.drillingtemperaturedata} />
          </Panel>
        </div>
        <div className="col-md-6">
          <Panel header="Drilling Speed">
            <LineChart labelName="Drilling Speed" yAxis={this.props.drillingspeeddata}/>
          </Panel>
        </div>
      </div>
    );

  return(
    machines
  );
  }
};

Machines.propTypes = {
  millingtemperaturedata: PropTypes.array.isRequired,
  drillingtemperaturedata: PropTypes.array.isRequired,
  drillingspeeddata: PropTypes.array.isRequired,
  millingspeeddata: PropTypes.array.isRequired
};

export default createContainer(() => {
  return {
    millingtemperaturedata: MillingTemperatureData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    drillingtemperaturedata: DrillingTemperatureData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    drillingspeeddata: DrillingSpeedData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    millingspeeddata: MillingSpeedData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
  };
}, Machines);
