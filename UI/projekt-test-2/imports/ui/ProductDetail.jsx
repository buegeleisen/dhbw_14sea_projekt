import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';

import ProductData from './api/productData.js';

class ProductDetail extends Component {

  render() {


  const render =(
    <div className="col-md-12 container">
      <div>
        <h1 className="section-heading">Product Detail</h1>
        <h1 className="section-heading">{this.product.id}</h1>
      </div>
      <div className="col-md-12">


      </div>

    </div>
  );

      return (
          render
            );
        }
  };

ProductDetail.propTypes= {
    product: PropTypes.object.isRequired,
};

export default createContainer(() => {
  return {
    product: ProductData.find(id: {this.props._id}),
  };
}, ProductDetail);
