import React, { Component, PropTypes } from 'react';
import ProductDetail from './ProductDetail.jsx';
import {ProductData} from '../api/productData.js';

export default class ProductDetailLayout extends Component {


  findData(){
    return ProductData.findOne({id: this.props.id});
  }



  render() {


    const render =(
        <div className="col-md-12">
          <ProductDetail product = {this.findData()} />
        </div>
      );

      return (
          render
            );
        }
  };

ProductDetailLayout.propTypes= {
    id: PropTypes.string,
};
