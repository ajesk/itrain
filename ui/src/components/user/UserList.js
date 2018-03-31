import React from 'react';
import axios from 'axios';
import UserListRow from './UserListRow';
import {get} from '../../util/breq'
//var breq = require('../../util/breq');
const log = require('simple-console-logger').getLogger('UserList');
const config = require('../../config');


function buildList(users) {
    if (!users) return;
    log.debug(users);
    return users.map(user => {
        return <UserListRow user={user} />
    })
}

/**
 * Display the contents of a single User
 */
class UserList extends React.Component {
    state = {
        users: []
    }

    componentDidMount() {
        // const users = get('/users', function(users) {
        //     UserList.setState({users})
        // });
        // this.setState({users});
        axios.get(config.service.mode + '://' +
            config.service.host + ':' +
            config.service.port + "/users"
        ).then(res => {
                const users = res.data;
                this.setState({users});
        }).catch(function (err) {
            log.debug(err);
        });
    }

    render() {
        return (
            <div>
                <div>
                    <h2>Users</h2>
                </div>
                <table className='table table-hover table-striped'>
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Position</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            buildList(this.state.users)
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default UserList;