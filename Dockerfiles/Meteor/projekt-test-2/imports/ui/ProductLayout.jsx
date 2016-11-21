import React, { Component, PropTypes } from 'react';
import ProductItem from './ProductItem.jsx';

import { createContainer } from 'meteor/react-meteor-data';

import {ProductData} from '../api/productData.js';

class ProductLayout extends Component {


  renderTable(){
    return this.props.productData.map((item) => (
      <ProductItem key={item.activemq.materialnumber} id={item.id} customer={item.activemq.customernumber} timestamp={item.activemq.timestamp} />
    ));
  };


render() {

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
      productData: ProductData.find({}, {sort:{_id: -1}, limit: 40} ).fetch(),
    };
  }, ProductLayout);
