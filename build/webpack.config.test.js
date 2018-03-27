const merge = require('webpack-merge');
const baseWebpackConfig = require('./webpack.config.base');

const UglifyJSPlugin = require('uglifyjs-webpack-plugin');

var testWebpackConfig = merge(baseWebpackConfig, {
    output: {
        publicPath: "//s-test.portal.chinacache.com/v4",
        //publicPath: "//localhost:8080",
        filename: "js/[name]-[chunkhash].js",
    },
    plugins: [
        new UglifyJSPlugin({
            mangle: {
                except: ['$super', '$', 'exports', 'require']
            }
        }),
    ],
});

module.exports = testWebpackConfig;
