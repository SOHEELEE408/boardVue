import { createApp } from 'vue'
import { router } from './router/index.js'

import BootstrapVue3 from "bootstrap-vue-3";
import axios from 'axios'

import App from './App.vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

// Create Vue Instance
const app = createApp(App)
app.use(router)
app.use(BootstrapVue3)

app.config.globalProperties.axios=axios

app.mount('#app')

