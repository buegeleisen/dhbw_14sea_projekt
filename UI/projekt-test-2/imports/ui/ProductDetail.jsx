import React, { Component, PropTypes } from 'react';
import BarChart from './BarChart.jsx';
import {Panel, ListGroup, ListGroupItem} from 'react-bootstrap';
import {LineChart} from 'react-easy-chart';
import * as Analysis from '../api/analysis.js';

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

  getLineArray(array){
    let total = [];
    for(let i = 0; i<array.length; i++){
        let data = {"x": i,"y": array[i]};
        total.push(data);
    }
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
          <div className="col-md-6">
            <Panel header="Product Data">
              <div className="col-md-12">
                <BarChart
                  values = {this.getERPFilesA()}
                  labels = {['a1','a2']}
                  label = "Analysis A"
                  backgroundColor = {['rgba(255, 99, 132, 0.2)','rgba(255, 99, 132, 0.2)']}
                  borderColor = {['rgba(255, 99, 132, 1)','rgba(255, 99, 132, 1)']}
                  />
              </div>
              <div className="col-md-12">
                <BarChart
                  values = {this.getERPFilesB()}
                  labels = {['b1','b2']}
                  label = "Analysis B"
                  backgroundColor = {['rgba(54, 162, 235, 0.2)','rgba(54, 162, 235, 0.2)']}
                  borderColor = {['rgba(54, 162, 235, 1)','rgba(54, 162, 235, 1)']}
                  />
              </div>
              <div className="col-md-12">
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



        <div className="col-md-6">
            <Panel header="Comparison to Average of All Products">
              <div className="col-md-12">
                <BarChart
                  values = {[Analysis.getERPAverageArray()[0],Analysis.getERPAverageArray()[1]]}
                  labels = {['a1','a2']}
                  label = "Analysis A"
                  backgroundColor = {['rgba(255, 99, 132, 0.2)','rgba(255, 99, 132, 0.2)']}
                  borderColor = {['rgba(255, 99, 132, 1)','rgba(255, 99, 132, 1)']}
                  />
              </div>
              <div className="col-md-12">
                <BarChart
                  values = {[Analysis.getERPAverageArray()[2],Analysis.getERPAverageArray()[3]]}
                  labels = {['b1','b2']}
                  label = "Analysis B"
                  backgroundColor = {['rgba(54, 162, 235, 0.2)','rgba(54, 162, 235, 0.2)']}
                  borderColor = {['rgba(54, 162, 235, 1)','rgba(54, 162, 235, 1)']}
                  />
              </div>
              <div className="col-md-12">
                <BarChart
                  values = {[Analysis.getERPAverageArray()[4],Analysis.getERPAverageArray()[5]]}
                  labels = {['em1','em2']}
                  label = "Analysis EM"
                  backgroundColor = {['rgba(255, 206, 86, 0.2)','rgba(255, 206, 86, 0.2)']}
                  borderColor = {['rgba(255, 206, 86, 1)','rgba(255, 206, 86, 1)']}
                  />
              </div>
          </Panel>
          </div>

          <div className="col-md-12">
            <h1 className="section-heading">Milling & Drilling Overview</h1>
            <div className="col-md-6">
              <Panel header="Milling Temperature">
                <LineChart
                  axes
                  interpolate={'cardinal'}
                  data={[this.getLineArray(this.props.product.millingHeat)]}
                  width={400}
                  height={300}
                  />
              </Panel>
            </div>
            <div className="col-md-6">
              <Panel header="Milling Speed">
                <LineChart
                  axes
                  interpolate={'cardinal'}
                  data={[this.getLineArray(this.props.product.millingHeat)]}
                  width={400}
                  height={300}
                  />
              </Panel>
            </div>
          <div className="col-md-6">
            <Panel header="Drilling Temperature">
              <LineChart
                axes
                interpolate={'cardinal'}
                data={[this.getLineArray(this.props.product.millingHeat)]}
                width={400}
                height={300}
                />
            </Panel>
          </div>
          <div className="col-md-6">
            <Panel header="Drilling Speed">
              <LineChart
                axes
                interpolate={'cardinal'}
                data={[this.getLineArray(this.props.product.millingHeat)]}
                width={400}
                height={300}
                />
            </Panel>
          </div>
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
