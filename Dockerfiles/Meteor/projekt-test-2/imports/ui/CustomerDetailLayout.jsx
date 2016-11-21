import React, { Component, PropTypes } from 'react';
import CustomerDetail from './CustomerDetail.jsx';
import * as Analysis from '../api/analysis.js';

export default class CustomerDetailLayout extends Component {

  render() {

    const render =(
        <div className="col-md-12">
          <CustomerDetail customer = {Analysis.getAllProductsFromCustomer(parseInt(this.props.id))} customerid={parseInt(this.props.id)}/>
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
