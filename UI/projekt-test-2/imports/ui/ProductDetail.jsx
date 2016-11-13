import React, { Component, PropTypes } from 'react';

import BarChart from './BarChart.jsx';
import {Panel} from 'react-bootstrap';

export default class ProductDetail extends Component {

  getERPFilesA(){
    let files = [];
    files.push(this.props.product.erpFile.a1);
    files.push(this.props.product.erpFile.a2);
    return files;
  }

  getERPFilesB(){
    let files = [];
    files.push(this.props.product.erpFile.b1);
    files.push(this.props.product.erpFile.b2);
    return files;
  }

  getERPFilesEM(){
    let files = [];
    files.push(this.props.product.erpFile.em1);
    files.push(this.props.product.erpFile.em2);
    return files;
  }

  render() {


    const render =(
      <div className="col-md-12 container">
        <div>
          <h1 className="section-heading">Product Detail</h1>
          <h1 className="section-heading">Product Number: {this.props.product.id}</h1>
        </div>

          <div className="col-md-12">
            <Panel>
              <p>CustomerID: {this.props.product.activemq.customernumber}</p>
              <p>Order Number: {this.props.product.activemq.ordernumber}</p>
              <p>Material Number: {this.props.product.activemq.materialnumber}</p>
              <p>Timestamp: {this.props.product.activemq.timestamp}</p>
            </Panel>
          </div>
          <div className="col-md-12">
            <Panel header="Product Data">
              <div className="col-md-4">
                <BarChart
                  values = {this.getERPFilesA()}
                  labels = {['a1','a2']}
                  label = "Analysis A"
                  backgroundColor = {['rgba(255, 99, 132, 0.2)','rgba(255, 99, 132, 0.2)']}
                  borderColor = {['rgba(255, 99, 132, 1)','rgba(255, 99, 132, 1)']}
                  />
              </div>
              <div className="col-md-4">
                <BarChart
                  values = {this.getERPFilesB()}
                  labels = {['b1','b2']}
                  label = "Analysis B"
                  backgroundColor = {['rgba(54, 162, 235, 0.2)','rgba(54, 162, 235, 0.2)']}
                  borderColor = {['rgba(54, 162, 235, 1)','rgba(54, 162, 235, 1)']}
                  />
              </div>
              <div className="col-md-4">
                <BarChart
                  values = {this.getERPFilesEM()}
                  labels = {['em1','em2']}
                  label = "Analysis EM"
                  backgroundColor = {['rgba(255, 206, 86, 0.2)','rgba(255, 206, 86, 0.2)']}
                  borderColor = {['rgba(255, 206, 86, 1)','rgba(255, 206, 86, 1)']}
                  />
              </div>
            </Panel>
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
};
