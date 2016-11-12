import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';
import {Panel} from 'react-bootstrap';
import ProductData from '../api/productData.js';

export default class CustomerDetail extends Component {
  render(){
    const orderDetail=(
      <div className="col-md-12 container">
        <div>
          <h1 className="section-heading">Customer Details for</h1>
          <h1 className="section-heading">Customer Number: {this.props.id}</h1>
        </div>
        <div className="col-md-12">
          <div className="col-md-4">
          <Panel>
            <p>OrderID: </p>
            <p>ProductID: </p>
            <p>CustomerID:</p>
          </Panel>
          </div>
        </div>
        <div>
          <h1 className="section-heading">This Customers Orders</h1>
        </div>
        <div className="col-md-12">
          <div className="col-md-6">
            OrderID:
          </div>
          <div className="col-md-6">
            ProductID:
          </div>
        </div>
      </div>
    )

  return(
    orderDetail
  );
};

};
CustomerDetail.propTypes={
  id: PropTypes.string,
};
