<template>
    <div>
        <String
            label="AuthorName"
            v-model="value.authorName"
            :editMode="editMode"
        />
        <Number
            label="AuthorId"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <String
            label="BookTitle"
            v-model="value.bookTitle"
            :editMode="editMode"
        />
        <String
            label="BookContent"
            v-model="value.bookContent"
            :editMode="editMode"
        />
        <Boolean
            label="FinalSave"
            v-model="value.finalSave"
            :editMode="editMode"
        />
        <String
            label="PublishStatus"
            v-model="value.publishStatus"
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
    name: 'PublishManage',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "publishManages",
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
