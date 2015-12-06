exports.config = {
    directConnect: true,
    framework: 'jasmine2',
    specs: [ 'spec.js' ],
    capabilities: {
        'browserName': 'chrome'
    },
    chromeDriver:'../node_modules/chromedriver/bin/chromedriver',
};