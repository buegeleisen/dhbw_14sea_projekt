import React, { Component, PropTypes } from 'react';
import {Button, FormGroup, FormControl, ControlLabel} from 'react-bootstrap';
import CustomerItem from'./CustomerItem.jsx';

import { createContainer } from 'meteor/react-meteor-data';

import {ProductData} from '../api/productData.js';


class CustomerCenter extends Component{

  mapMongoDB(){
    return this.props.productData.map((item) => (
       item.activemq.customernumber
    ));
  };

  test(){
    for(let i =0; i< this.mapMongoDB().length; i++){
      console.log(this.mapMongoDB()[i]);
    }
  }

  renderTable(){
    return this.mapMongoDB().map((value) =>(
      <CustomerItem key={value} customerid={value} />
    ));
  };

  countHandler(event){
    this.count = event.target.value;
    console.log(this.count);
  };

  sortHandler(event){
    if(event.target.value=="latest"){
      this.sort = -1;
      console.log(this.sort);
    }
    else if (event.target.value == "oldest") {
      this.sort = 1;
      console.log(this.sort);
    }

  }

  render() {
    let count = 5;
    let sort = -1;
    this.test();

    const panel= (

      <div className="col-md-12 container">
      <div>
        <h1 className="section-heading">Customers and Orders Center</h1>
      </div>
      <div>
        <div className="col-md-2">
          <FormGroup controlId="formControlsSelect">
            <ControlLabel>Count</ControlLabel>
            <FormControl componentClass="select" placeholder="select" onChange={this.countHandler}>
              <option value={5}>5</option>
              <option value={10}>10</option>
              <option value={25}>25</option>
              <option value={50}>50</option>
              <option value={100}>100</option>
            </FormControl>
          </FormGroup>
        </div>
        <div className="col-md-2">
          <FormGroup controlId="formControlsSelect" disabled>
            <ControlLabel>Sorty By</ControlLabel>
            <FormControl componentClass="select" placeholder="select" onChange={this.sortHandler}>
              <option value="latest">latest</option>
              <option value="oldest">oldest</option>
            </FormControl>
          </FormGroup>
        </div>
      </div>
      <div className="col-md-12">
        {this.renderTable()}
      </div>
    </div>
    );

      return (
        panel
            );
        }
  };

  CustomerCenter.propTypes = {
    productData: PropTypes.array.isRequired,
  };

  export default createContainer(() => {
    return {
      productData: ProductData.find({}, {sort:{_id: this.sort}, limit: this.count} ).fetch(),
    };
  }, CustomerCenter);
