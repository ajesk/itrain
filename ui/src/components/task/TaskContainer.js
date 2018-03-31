import React from 'react';
import PropTypes from 'prop-types';
import { Field, reduxForm } from 'redux-form';
import TaskList from './TaskList';
import Task from './Task';
const log = require('simple-console-logger').getLogger('TaskContainer');

function taskPage(id) {
    return (
        <Task taskId={id} />
    )
}

function taskList() {
    return (
        <TaskList />
    )
}

/**
 * Display the contents of a single task
 */
class TaskContainer extends React.Component {
    render() {
        return (
            <div className='container-fluid'>
                {this.props.id ? taskPage(this.props.id) : taskList()}
            </div>
        )
    }
}

export default TaskContainer;