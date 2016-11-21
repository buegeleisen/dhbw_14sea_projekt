import React, { Component, PropTypes } from 'react';


export default class JaCom extends Component{

  render() {
    const logo = (
      <div className="logo"><a href={this.props.route}><p className="ja">JA</p><p className="com">.COM</p></a></div>
    );

      return (
          logo
            );
        }
};

JaCom.propTypes = {
  route: PropTypes.string
};
