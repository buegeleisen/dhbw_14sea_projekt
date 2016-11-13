import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';
import {Panel} from 'react-bootstrap';
import ProductLayout from './ProductLayout.jsx';
import ProductData from '../api/productData.js';
import ProductItem from './ProductItem.jsx';

export default class CustomerDetail extends Component {

  renderTable(){
    return this.props.customer.map((item) => (
      <ProductItem key={item.activemq.materialnumber} id={item.id} customer={item.activemq.customernumber} timestamp={item.activemq.timestamp} />
    ));
  };


  render(){
    const orderDetail=(
      <div className="col-md-12 container">
        <div>
          <h1 className="section-heading">Customer Details for</h1>
          <h1 className="section-heading">Customer Number: {this.props.customerid}</h1>
        </div>
        <div className="col-md-12">
          <div className="col-md-4">
          <Panel>
            <p>CustomerID: {this.props.customerid}</p>
            <p>Orders Count: {this.props.customer.length}</p>
          </Panel>
          </div>
        </div>
        <div>
          <h1 className="section-heading">This Customers Orders</h1>
        </div>
        <div className="col-md-12">
          {this.renderTable()}
        </div>
      </div>
    )

  return(
    orderDetail
  );
};

};

CustomerDetail.propTypes={
  customerid: PropTypes.number,
  customer: PropTypes.array,
};
