import React from 'react';

const expandType = {
  isExpanded: "isExpanded",
  isNotExpanded: "isNotExpanded"
}

const getExpandSpan = (expandType) => {
  if(expandType === "isExpanded") {
    return(
      <span className="roll-up">&#5123;</span>
    );
  }

  if(expandType === "isNotExpanded") {
    return(
      <span className="roll-down">&#5121;</span>
    );
  }
  return null;
}

const dropDown = (name) => {
  //let a = document.getElementById("dropdown-menu");
  // if ( a.style.display == 'none' )
  //   a.style.display = 'block';
  // else
  //   if ( a.style.display == 'block' )
  //   a.style.display = 'none';
}

const Comment = ({name, comment, commentIsVisible, expandType}) => {
  return(
    <div>
      <div style={{display: "flex", flexDirection: "row", justifyContent: "space-between", alignItems: "center", padding: "5px"}}>
        <div style={{width: "20px", fontSize: "7pt"}}>
          {getExpandSpan(expandType)}
        </div>
        <div style={{flexGrow: 1}}>
          <span className="font-weight-bold" style={{cursor: "pointer"}}>
            {name}
          </span>
        </div>

        <div style={{width: "30px"}}>
          <div className="dropdown-btn-group" role="group">
            <a className="dropdown-btn" onClick={dropDown()}>&#5121;</a>
              <ul id="dropdown-menu">
                <li className="dropdown-item">Reply</li>
              </ul>
          </div>
        </div>

      </div>
      {
        commentIsVisible ? (
          <div style={{marginLeft: "20px", marginRight: "50px", color: "grey", fontStyle: "italic"}}>
            {comment}
          </div>
        ): undefined}
    </div>
  );
};

export default Comment;
export {expandType};
