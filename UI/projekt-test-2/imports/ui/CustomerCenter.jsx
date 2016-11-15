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

  getMongoDBSet(){
    return Array.from(new Set(this.mapMongoDB()));
  }

  renderTable(){
    return this.getMongoDBSet().map((value) =>(
      <CustomerItem key={value} customerid={value} />
    ));
  };



  render() {

    const panel= (

      <div className="col-md-12 container">
      <div>
        <h1 className="section-heading">Customer Center</h1>
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
      productData: ProductData.find({}, {sort:{_id: -1}, limit: 40} ).fetch(),
    };
  }, CustomerCenter);
