import React, { Component, PropTypes } from 'react';
import { createContainer } from 'meteor/react-meteor-data';
import RadarChart from './RadarChart.jsx'
import ProductData from '../api/productData.js';
import {Panel} from 'react-bootstrap';

export default class ProductDetail extends Component {

  render() {


  const render =(
    <div className="col-md-12 container">
      <div>
        <h1 className="section-heading">Product Detail</h1>
        <h1 className="section-heading">{this.props.id}</h1>
      </div>
      <div className="col-md-12">
        <div className="col-md-8">
          <Panel>
            <RadarChart />
          </Panel>
        </div>
        <div className="col-md-4">
          <Panel>
            <p>CustomerID: </p>
            <p>Order Number: </p>
            <p>Material Number: </p>
            <p>Timestamp: </p>
          </Panel>
        </div>

      </div>
      <div className="col-md-12">
          <Panel header="Comparison to Average of All Products">
            <RadarChart />
        </Panel>
        </div>
        <div className="col-md-12">
          <Panel header="Comparison to Average of All Customer Products">
            <RadarChart />
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
    id: PropTypes.string,
    product: PropTypes.object,
};

/*export default createContainer(() => {
  return {
    product: ProductData.findOne({id: this.props.id}),
  };
}, ProductDetail);*/
