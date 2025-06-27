<template>
    <div>
        <Number
            label="RequestId"
            v-model="value.requestId"
            :editMode="editMode"
        />
        <String
            label="RequestType"
            v-model="value.requestType"
            :editMode="editMode"
        />
        <String
            label="TargetId"
            v-model="value.targetId"
            :editMode="editMode"
        />
        <String
            label="RequestedAt"
            v-model="value.requestedAt"
            :editMode="editMode"
        />
        <String
            label="Status"
            v-model="value.status"
            :editMode="editMode"
        />
        <Number
            label="AdminId"
            v-model="value.adminId"
            :editMode="editMode"
        />
        <Date
            label="ApprovedAt"
            v-model="value.approvedAt"
            :editMode="editMode"
        />
        <String
            label="Message"
            v-model="value.message"
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
    name: 'Admin',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "admins",
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
