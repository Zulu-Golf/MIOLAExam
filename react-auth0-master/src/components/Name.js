import React from "react";

import {AuthConsumer} from "../authContext";

const Name = () => (
  <AuthConsumer>
    {({user}) => (
      <div>
       
          {user.name}
         
      </div>
    )}
  </AuthConsumer>
);

export default Name;