import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';

import LineChart from './LineChart.jsx';
import {Panel, ListGroup, ListGroupItem} from 'react-bootstrap';
import { MillingHeatData, DrillingHeatData, MillingSpeedData, DrillingSpeedData } from '../api/chartData.js';



class Machines extends Component{

  renderLast(array){
    return array.map((item) => (
     item.y
   ));
  }

  render(){

    const machines = (

      <div className="col-md-12 container">
        <div>
          <h1 className="section-heading">Machine Overview</h1>
          <Panel>
            <div className="col-md-2"></div>
            <div className="col-md-1">Sensor 1</div>
            <div className="col-md-1">Sensor 2</div>
            <div className="col-md-1">Milling</div>
            <div className="col-md-1">Sensor 3</div>
            <div className="col-md-1">Drilling</div>
            <div className="col-md-1">Sensor 4</div>
            <div className="col-md-1">Sensor 5</div>

          </Panel>
        </div>

          <h1 className="section-heading">Milling Overview</h1>
          <div className="col-md-6">
            <Panel header="Milling Temperature">
                <ListGroup fill>
                  <ListGroupItem>Temperature: {this.renderLast(this.props.millingheatdata)[0]}</ListGroupItem>
              </ListGroup>
              <div><LineChart
                labelName="Milling Temperature"
                yAxis={this.props.millingheatdata}
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
              <ListGroupItem>Temperature: {this.renderLast(this.props.drillingheatdata)[0]}</ListGroupItem>
          </ListGroup>
            <LineChart
              labelName="Drilling Temperature"
              yAxis={this.props.drillingheatdata}
              backgroundColor= "#548235"
              borderColor= "#548235"
              pointHoverBackgroundColor= "#548235"
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
              backgroundColor= "#548235"
              borderColor= "#548235"
              pointHoverBackgroundColor= "#548235"
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
  millingheatdata: PropTypes.array.isRequired,
  drillingheatdata: PropTypes.array.isRequired,
  drillingspeeddata: PropTypes.array.isRequired,
  millingspeeddata: PropTypes.array.isRequired,
};

export default createContainer(() => {
  return {
    millingheatdata: MillingHeatData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    drillingheatdata: DrillingHeatData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    drillingspeeddata: DrillingSpeedData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
    millingspeeddata: MillingSpeedData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
  };
}, Machines);
