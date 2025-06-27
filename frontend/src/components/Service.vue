<template>
    <div>
        <Number
            label="PublicationId"
            v-model="value.publicationId"
            :editMode="editMode"
        />
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
            label="Title"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="SummaryText"
            v-model="value.summaryText"
            :editMode="editMode"
        />
        <String
            label="CoverImageUrl"
            v-model="value.coverImageUrl"
            :editMode="editMode"
        />
        <String
            label="ProductRegistered"
            v-model="value.productRegistered"
            :editMode="editMode"
        />
        <Boolean
            label="IsPublishCompleted"
            v-model="value.isPublishCompleted"
            :editMode="editMode"
        />
        <String
            label="IsBestSeller"
            v-model="value.isBestSeller"
            :editMode="editMode"
        />
        <String
            label="Status"
            v-model="value.status"
            :editMode="editMode"
        />
        <Date
            label="PublishedDate"
            v-model="value.publishedDate"
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
    name: 'Service',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "services",
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
