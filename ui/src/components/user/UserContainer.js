import React from 'react';
import UserList from './UserList';
import User from './User';
const log = require('simple-console-logger').getLogger('UserContainer');

function userPage(id) {
    return (
        <User userId={id} />
    )
}

function userList() {
    return (
        <UserList />
    )
}

/**
 * Display the contents of a single User
 */
class UserContainer extends React.Component {
    render() {
        log.debug(this.props)

        return (
            <div className='container-fluid'>
                {this.props.params ? userPage(this.props.params.id) : userList()}
            </div>
        )
    }
}

export default UserContainer;