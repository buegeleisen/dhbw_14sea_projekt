import React, { Component, PropTypes } from 'react';
import {} from 'react-bootstrap';





export default class TableElement extends Component{
  render() {
      return (
        <tr>
          <td>{this.props.tableText}</td>
          <td>{this.props.tableText}</td>
          <td>{this.props.tableText}</td>
        </tr>
            );
        }
  };

  TableElement.propTypes = {
    tableText: PropTypes.object.isRequired,
  };
