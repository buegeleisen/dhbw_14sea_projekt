import React, { Component, PropTypes } from 'react';
import ProductItem from './ProductItem.jsx';
import {FormGroup, FormControl, ControlLabel} from 'react-bootstrap';

import { createContainer } from 'meteor/react-meteor-data';

import {ProductData} from '../api/productData.js';

class ProductLayout extends Component {


  renderTable(){
    return this.props.productData.map((item) => (
      <ProductItem key={item.activemq.materialnumber} id={item.id} customer={item.activemq.customernumber} timestamp={item.activemq.timestamp} />
    ));
  };

  countHandler(event){
    this.count = event.target.value;
    console.log(this.count);
  };

  sortHandler(event){
    if(event.target.value=="latest"){
      this.sort = -1;
      console.log(this.sort);
    }
    else if (event.target.value == "oldest") {
      this.sort = 1;
      console.log(this.sort);
    }

  }

render() {
  let count = 5;
  let sort = 1;

  const render =(
    <div>
      <div className="col-md-12 container">
        <h1 className="section-heading">Product Overview</h1>
      </div>
        <div className="col-md-2">
          <FormGroup controlId="formControlsSelect">
            <ControlLabel>Count</ControlLabel>
            <FormControl componentClass="select" placeholder="select" onChange={this.countHandler}>
              <option value={5}>5</option>
              <option value={10}>10</option>
              <option value={25}>25</option>
              <option value={50}>50</option>
              <option value={100}>100</option>
            </FormControl>
          </FormGroup>
        </div>
        <div className="col-md-2">
          <FormGroup controlId="formControlsSelect">
            <ControlLabel>Sorty By</ControlLabel>
            <FormControl componentClass="select" placeholder="select" onChange={this.sortHandler}>
              <option value="latest">latest</option>
              <option value="oldest">oldest</option>
            </FormControl>
          </FormGroup>
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
      productData: ProductData.find({}, {sort:{_id: this.sort}, limit: this.count} ).fetch(),
    };
  }, ProductLayout);
