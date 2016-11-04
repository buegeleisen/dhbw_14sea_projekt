import React, { Component, PropTypes } from 'react';
import {Panel, Glyphicon} from 'react-bootstrap';

export default class CustomerItem extends Component{

  render() {
      return (
        <div className="productList">
          <Panel>
            <div className="myPanel">
              <div className="col-md-3">
                <p>OrderID: </p>
                <p>{this.props.orderid}</p>
              </div>
              <div className="col-md-4">
                <p>CustomerID: </p>
                <p>{this.props.customerid}</p>
              </div>
              <div className="col-md-3">
                <p>ProductID: </p>
                <p>{this.props.productid}</p>
              </div>
              <div className="col-md-2 click">
                <a href={"/customercenter/" + this.props.orderid}>
                  <Glyphicon glyph="chevron-right" />
                </a>
              </div>
            </div>
          </Panel>
        </div>
            );
        }
  };

CustomerItem.propTypes= {
  orderid: PropTypes.number,
  customerid: PropTypes.string,
  productid: PropTypes.number
};
