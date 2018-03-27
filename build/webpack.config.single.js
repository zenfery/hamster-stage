const path = require('path');
const merge = require('webpack-merge');
const baseWebpackConfig = require('./webpack.config.base');
const webpack = require('webpack');

var distDir = "../src/main/webapp";

var devWebpackConfig = merge(baseWebpackConfig, {
    devtool: "eval-source-map",
    output: {
        publicPath: "/",
    },
    devServer: {
        hot: true,
        contentBase: path.resolve(__dirname, distDir),
        publicPath: '/',
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
    ]
});

module.exports = devWebpackConfig;
