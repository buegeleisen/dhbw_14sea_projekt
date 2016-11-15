import React, { Component, PropTypes } from 'react';
import ProductItem from './ProductItem.jsx';
import {FormGroup, FormControl, ControlLabel} from 'react-bootstrap';

import { createContainer } from 'meteor/react-meteor-data';

import {ProductData} from '../api/productData.js';

class ProductLayout extends Component {


  renderTable(){
    return this.props.productData.map((item) => (
      <ProductItem key={item.activemq.materialnumber} id={item.id} customer={item.activemq.customernumber} timestamp={item.activemq.timestamp} />
    ));
  };


render() {
  let count = 2;
  let sort = 1;
  console.log(this.filterTable(2));

  const render =(
    <div>
      <div className="col-md-12 container">
        <h1 className="section-heading">Product Overview</h1>
      </div>
        <div className="col-md-12">
          {this.renderTable()}
        </div>
      </div>

  );
      return (
          render
            );
        }
  };

  ProductLayout.propTypes = {
    productData: PropTypes.array.isRequired,
  };

  export default createContainer(() => {
    return {
      productData: ProductData.find({}, {sort:{_id: this.sort}, limit: this.count} ).fetch(),
    };
  }, ProductLayout);
