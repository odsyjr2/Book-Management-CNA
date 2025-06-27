<template>
    <div>
        <String
            label="Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="Message"
            v-model="value.message"
            :editMode="editMode"
        />
        <Number
            label="Point"
            v-model="value.point"
            :editMode="editMode"
        />
        <Boolean
            label="JoinStatus"
            v-model="value.joinStatus"
            :editMode="editMode"
        />
        <Boolean
            label="KtCustomer"
            v-model="value.ktCustomer"
            :editMode="editMode"
        />
        <String
            label="LoginStatus"
            v-model="value.loginStatus"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Subscriber',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscribers",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
