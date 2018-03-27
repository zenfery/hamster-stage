module.exports = function (env) {
    if(! env ){
        env = "dev";
    }
    return require("./build/webpack.config."+env+".js");
};