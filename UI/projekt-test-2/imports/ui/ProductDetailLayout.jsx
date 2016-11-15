import React, { Component, PropTypes } from 'react';
import ProductDetail from './ProductDetail.jsx';
import {ProductData} from '../api/productData.js';

export default class ProductDetailLayout extends Component {

  test(log){
    console.log(log);
  }

  findData(){
    return ProductData.findOne({id: parseInt(this.props.id)});
  }



  render() {
    this.test(this.props.id);
    this.test(this.findData());


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
