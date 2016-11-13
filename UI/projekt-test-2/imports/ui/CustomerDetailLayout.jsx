import React, { Component, PropTypes } from 'react';
import CustomerDetail from './CustomerDetail.jsx';
import {ProductData} from '../api/productData.js';

export default class CustomerDetailLayout extends Component {

  test(log){
    console.log(log);
  }

  findData(){
    return ProductData.find({"activemq.customernumber": parseInt(this.props.id)}, {sort:{_id:-1}}).fetch();
  }

  getArray(){
    return this.findData().map((customerdata) =>(
        customerdata
      ));
  }


  render() {
    this.test(this.props.id);
    this.test(this.getArray());


    const render =(
        <div className="col-md-12">
          <CustomerDetail customer = {this.getArray()} customerid={parseInt(this.props.id)}/>
        </div>
      );

      return (
          render
            );
        }
  };

CustomerDetailLayout.propTypes= {
    id: PropTypes.string,
};
