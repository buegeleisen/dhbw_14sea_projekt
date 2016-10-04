import React, { Component } from 'react';
import {Navbar, Nav, NavItem, Glyphicon} from 'react-bootstrap';

const navbarInstance = (
  <Navbar>
    <Navbar.Header>
      <Navbar.Brand>
        <a href="#">JA.COM</a>
      </Navbar.Brand>
      <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
      <Nav>
        <NavItem eventKey={1} href="#"><Glyphicon glyph="fa-smile-o" />Maschinen</NavItem>
        <NavItem eventKey={2} href="#">ERP</NavItem>
        <NavItem eventKey={2} href="#">Analyse</NavItem>
      </Nav>
      <Nav pullRight>
      </Nav>
    </Navbar.Collapse>
  </Navbar>
);

export default React.createClass({


  render() {
      return (
          navbarInstance
            );
        }
  });
