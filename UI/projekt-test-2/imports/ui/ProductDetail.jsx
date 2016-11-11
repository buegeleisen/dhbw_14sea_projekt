import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';
import BarChart from './BarChart.jsx';
import {Panel} from 'react-bootstrap';

import {ProductData} from '../api/productData.js';

export default class ProductDetail extends Component {

  test(log){
    console.log(log);
  }

  getID(){
    return this.props.id;
  }

  render() {
    this.test(this.props.product);
    const number = this.getID();

    const render =(
      <div className="col-md-12 container">
        <div>
          <h1 className="section-heading">Product Detail</h1>
          <h1 className="section-heading">{this.props.id}</h1>
        </div>
        <div className="col-md-12">
          <div className="col-md-8">
            <Panel>
              <BarChart />
            </Panel>
          </div>
          <div className="col-md-4">
            <Panel>
              <p>CustomerID: {this.props.product[0].activemq.customernumber}</p>
              <p>Order Number: {this.props.product[0].activemq.ordernumber}</p>
              <p>Material Number: {this.props.product[0].activemq.customernumber}</p>
              <p>Timestamp: {this.props.product[0].activemq.timestamp}</p>
            </Panel>
          </div>

        </div>
        <div className="col-md-12">
            <Panel header="Comparison to Average of All Products">

          </Panel>
          </div>
          <div className="col-md-12">
            <Panel header="Comparison to Average of All Customer Products">

            </Panel>
          </div>
      </div>
    );

      return (
          render
            );
        }
  };

ProductDetail.propTypes= {
    product: PropTypes.object,
    id: PropTypes.number,
};

export default createContainer(() => {
  return {

  };
}, ProductDetail);
