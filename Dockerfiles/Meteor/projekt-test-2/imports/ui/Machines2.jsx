import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';
import {LineChart} from 'react-easy-chart';
import {Panel, ListGroup, ListGroupItem} from 'react-bootstrap';
import { MillingHeatData, DrillingHeatData, MillingSpeedData, DrillingSpeedData } from '../api/chartData.js';



class Machines2 extends Component{

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

        </div>

          <h1 className="section-heading">Milling Overview</h1>
          <div className="col-md-6">
            <Panel header="Milling Temperature">
                <ListGroup fill>
                  <ListGroupItem>Temperature: {this.renderLast(this.props.millingheatdata)[0]}</ListGroupItem>
              </ListGroup>
              <div>
                <LineChart
                  axes
                  interpolate={'cardinal'}
                  data={[this.props.millingheatdata]}
                  width={400}
                  height={300}
                  />
              </div>
            </Panel>
          </div>
          <div className="col-md-6">
            <Panel header="Milling Speed">
              <ListGroup fill>
                <ListGroupItem>Speed: {this.renderLast(this.props.millingspeeddata)[0]}</ListGroupItem>
            </ListGroup>
            <div>
              <LineChart
                axes
                interpolate={'cardinal'}
                data={[this.props.millingspeeddata]}
                width={400}
                height={300}
                />
            </div>
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
          <div>
            <LineChart
              axes
              interpolate={'cardinal'}
              data={[this.props.drillingheatdata]}
              width={400}
              height={300}
              />
          </div>
          </Panel>
        </div>
        <div className="col-md-6">
          <Panel header="Drilling Speed">
            <ListGroup fill>
              <ListGroupItem>Speed: {this.renderLast(this.props.drillingspeeddata)[0]}</ListGroupItem>
          </ListGroup>
          <div>
            <LineChart
              axes
              interpolate={'cardinal'}
              data={[this.props.drillingspeeddata]}
              width={400}
              height={300}
              />
          </div>
          </Panel>
        </div>
      </div>
    );

  return(
    machines
  );
  }
};

Machines2.propTypes = {
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
}, Machines2);
