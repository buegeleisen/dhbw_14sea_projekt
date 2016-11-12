import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';

import LineChart from './LineChart.jsx';
import {Panel, ListGroup, ListGroupItem} from 'react-bootstrap';
import { MillingTemperatureData, DrillingTemperatureData, MillingSpeedData, DrillingSpeedData } from '../api/chartData.js';



class Machines extends Component{

  renderLast(array){
    return array.map((item) => (
     item.y
  ));
  }

  test(log){
    console.log(log)
  }

  render(){

    const machines = (

      <div className="col-md-12 container">
        <div>
          <h1 className="section-heading">Machine Overview</h1>
          <Panel>
            <div className="col-md-1"></div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
            <div className="col-md-1">Status 1</div>
          </Panel>
        </div>

          <h1 className="section-heading">Milling Overview</h1>
          <div className="col-md-6">
            <Panel header="Milling Temperature">
                <ListGroup fill>
                  <ListGroupItem>Temperature: {this.renderLast(this.props.millingtemperaturedata)[0]}</ListGroupItem>
              </ListGroup>
              <div><LineChart
                labelName="Milling Temperature"
                yAxis={this.props.millingtemperaturedata}
                backgroundColor= "#D84315"
                borderColor= "#D84315"
                pointHoverBackgroundColor= "#D84315"
                /></div>
            </Panel>
          </div>
          <div className="col-md-6">
            <Panel header="Milling Speed">
              <ListGroup fill>
                <ListGroupItem>Speed: {this.renderLast(this.props.millingspeeddata)[0]}</ListGroupItem>
            </ListGroup>
              <LineChart
                labelName="Milling Speed"
                yAxis={this.props.millingspeeddata}
                backgroundColor= "#D84315"
                borderColor= "#D84315"
                pointHoverBackgroundColor= "#D84315"
                />
            </Panel>
          </div>


        <div >
          <h1 className="section-heading">Drilling Overview</h1>
        </div>
        <div className="col-md-6">
          <Panel header="Drilling Temperature">
            <ListGroup fill>
              <ListGroupItem>Temperature: {this.renderLast(this.props.drillingtemperaturedata)[0]}</ListGroupItem>
          </ListGroup>
            <LineChart
              labelName="Drilling Temperature"
              yAxis={this.props.drillingtemperaturedata}

              />
          </Panel>
        </div>
        <div className="col-md-6">
          <Panel header="Drilling Speed">
            <ListGroup fill>
              <ListGroupItem>Speed: {this.renderLast(this.props.drillingspeeddata)[0]}</ListGroupItem>
          </ListGroup>
            <LineChart
              labelName="Drilling Speed"
              yAxis={this.props.drillingspeeddata}

              />
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
  millingspeeddata: PropTypes.array.isRequired,
};

export default createContainer(() => {
  return {
    millingtemperaturedata: MillingTemperatureData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    drillingtemperaturedata: DrillingTemperatureData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    drillingspeeddata: DrillingSpeedData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    millingspeeddata: MillingSpeedData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
  };
}, Machines);
