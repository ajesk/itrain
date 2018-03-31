import React from 'react';
import PropTypes from 'prop-types';
import axios from 'axios';
import { Field, reduxForm } from 'redux-form';
const config = require('../../config');
const log = require('simple-console-logger').getLogger('User');

/**
 * Display the contents of a single User
 */
class User extends React.Component {

    componentDidMount() {
        axios.get(config.service.mode + '://' +
            config.service.host + ':' +
            config.service.port + "/users/" +
            this.props.userId
        ).then(res => {
                const users = res.data;
                this.setState({users});
        }).catch(function (err) {
            log.debug(err);
        });
    }

    render() {
        return (
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        )
    }
}

export default User;